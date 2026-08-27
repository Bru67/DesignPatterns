package br.pucpr.user.column;

import br.pucpr.table.model.ColumnData;
import br.pucpr.user.User;

public class IdColumn implements ColumnData<User> {
  @Override
  public String header() {
    return "  ID";
  }

  @Override
  public String get(User user) {
    final var id = user.id();
    return id != null ? "%4d".formatted(id) : "-";
  }
}
