package cat.itb.reedbooks;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class BooksViewModel extends ViewModel {
    static ArrayList<BooksModel> booksregister = new ArrayList<>();

    public BooksViewModel() {
        booksregister.add(new BooksModel("Joc de trons", "George R.R. Martin", "reading", 1, 6));
        booksregister.add(new BooksModel("El archimo de las tormentas", "Brandon Sanderson", "want to read", 0, 6));
        booksregister.add(new BooksModel("Escape Book", "Ivan Tapia", "read", 2, 4));
        booksregister.add(new BooksModel("Endgame", "James Frey", "read", 2, 3));
        booksregister.add(new BooksModel("El nombre del viento", "Patrick Rothfuss", "want to read", 0, 6));
        booksregister.add(new BooksModel("Fi de curs a Bucarest", "Juan Pinyol", "read", 2, 4));
        booksregister.add(new BooksModel("La ma negre", "Jaume Copons", "read", 2, 3));
        booksregister.add(new BooksModel("Escape Book 2", "Ivan Tapia", "want to read", 0, 6));
        booksregister.add(new BooksModel("Tirant Lo Blanc", "Joanot Martorell", "read", 2, 1));
        booksregister.add(new BooksModel("Overlord",  "\tKugane Maruyama", "want to read", 0, 6));
    }
}
