package br.pucpr.user.column;

import br.pucpr.table.model.ColumnData;
import br.pucpr.user.User;

public class EmailColumn implements ColumnData<User> {

    @Override
    public String header() {
        return "       E-MAIL       ";
    }

    @Override
    public String get(User user) {
        String email = user.email();
        return email == null || !email.contains("@") ? "INVÁLIDO" : email;
    }
}
