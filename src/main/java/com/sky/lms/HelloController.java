    package com.sky.lms;

    import com.sky.lms.models.Book;
    import javafx.beans.property.ReadOnlyStringWrapper;
    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.scene.control.*;
    import javafx.scene.control.cell.PropertyValueFactory;

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
            bookNameColumn.setCellValueFactory(cell ->
                    new ReadOnlyStringWrapper(
                            cell.getValue().getBookName())
            );
            descriptionColumn.setCellValueFactory(cell ->
                    new ReadOnlyStringWrapper(
                            cell.getValue().getDescription())
            );

            isbnColumn.setCellValueFactory(cell ->
                    new ReadOnlyStringWrapper(
                            cell.getValue().getIsbn())
            );
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
    }