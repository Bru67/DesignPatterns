package br.pucpr.user.column;

import br.pucpr.table.model.ColumnData;
import br.pucpr.user.User;

public class CpfColumn implements ColumnData<User> {

    private final boolean mask;
    public CpfColumn(boolean mask) {
        this.mask = mask;
    }

    @Override
    public String header() {
        return "       CPF      ";
    }

    @Override
    public String get(User user) {
        String cpf = user.cpf();

        if (cpf == null || cpf.length() != 11) {
            return "CPF INVÁLIDO";
        }

        if (mask) {
            return "***." + cpf.substring(3, 6)
                    + "." + cpf.substring(6, 9)
                    + "-**";
        }

        return cpf.substring(0, 3)
                + "." + cpf.substring(3, 6)
                + "." + cpf.substring(6, 9)
                + "-" + cpf.substring(9, 11);
    }
}