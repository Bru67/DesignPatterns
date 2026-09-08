package br.pucpr.table.model;
public class PagedTableData implements TableData {

    private final TableData data;
    private final int pageSize;
    private int currentPage;

    public PagedTableData(TableData data, int pageSize) {
        if (data == null) {
            throw new IllegalArgumentException("Data não pode ser null");
        }

        if (pageSize <= 0) {
            throw new IllegalArgumentException(
                    "Page size deve ser maior que 0"
            );
        }
        this.data = data;
        this.pageSize = pageSize;
        this.currentPage = 0;
    }

    @Override
    public int rowCount() {
        int start = currentPage * pageSize;
        if (start >= data.rowCount()) {
            return 0;
        }
        return Math.min(
                pageSize,
                data.rowCount() - start
        );
    }

    @Override
    public int colCount() {
        return data.colCount();
    }

    @Override
    public String header(int col) {
        return data.header(col);
    }

    @Override
    public String get(int row, int col) {
        int realRow = currentPage * pageSize + row;

        return data.get(realRow, col);
    }

    public int pageCount() {
        return (int) Math.ceil(
                (double) data.rowCount() / pageSize
        );
    }

    public void nextPage() {
        if (currentPage < pageCount() - 1) {
            currentPage++;
        }
    }

    public void previousPage() {
        if (currentPage > 0) {
            currentPage--;
        }
    }

    public void goToPage(int page) {
        if (page < 0 || page >= pageCount()) {
            throw new IllegalArgumentException(
                    "Página inválida"
            );
        }
        currentPage = page;
    }
}