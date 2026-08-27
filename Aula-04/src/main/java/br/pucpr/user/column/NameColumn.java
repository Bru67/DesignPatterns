package br.pucpr.user.column;

import br.pucpr.table.model.ColumnData;
import br.pucpr.user.User;

public class NameColumn implements ColumnData<User> {

    @Override
    public String header() {
        return "          NOME           ";
    }

    @Override
    public String get(User user) {
        if (user.name() == null || user.name().isEmpty()) {
            return "NÃO INFORMADO";
        }

        return user.name();
    }
}