    package com.sky.lms;

    import com.sky.lms.models.Book;
    import javafx.beans.property.ReadOnlyStringWrapper;
    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.scene.control.*;
    import javafx.scene.control.cell.PropertyValueFactory;

    import java.sql.PreparedStatement;
    import java.sql.ResultSet;

    public class HelloController {
        @FXML

        public TextField bookName;
        public TextField isbn;
        public TextArea bookDescription;
        public TableView<Book> tableView;
        public TableColumn<Book, String> bookNameColumn;
        public TableColumn<Book,String> descriptionColumn;
        public TableColumn<Book,String> isbnColumn;

        @FXML
        public void initialize(){
            initializeColumns();
            getBooks();
        }

        public void onAddBookEvent(ActionEvent actionEvent) {
            var count = (int) tableView.getItems().size();
            count++;

            var name = bookName.getText();
            var description = bookDescription.getText();
            var isbnText = isbn.getText();
            var book = new Book(count, name, description, isbnText);

            tableView.getItems().add(book);
        }



        private void initializeColumns(){
            bookNameColumn.setCellValueFactory(cell ->
                    new ReadOnlyStringWrapper(cell.getValue().getBookName())
            );
            descriptionColumn.setCellValueFactory(cell ->
                    new ReadOnlyStringWrapper(cell.getValue().getDescription())
            );

            isbnColumn.setCellValueFactory(cell ->
                    new ReadOnlyStringWrapper(cell.getValue().getIsbn())
            );
        }

        private void getBooks(){
            String sql = "SELECT * FROM books";

            try (PreparedStatement stmt = DatabaseConnection
                    .getInstance()
                    .getConnection()
                    .prepareStatement(sql);

                    ResultSet rs = stmt.executeQuery();
            ) {

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    String isbn = rs.getString("isbn");

                    var book = new Book(id, name, description, isbn);

                    tableView.getItems().add(book);
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }