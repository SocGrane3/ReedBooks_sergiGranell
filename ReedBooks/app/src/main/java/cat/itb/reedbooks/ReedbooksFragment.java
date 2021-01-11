package cat.itb.reedbooks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

public class ReedbooksFragment extends Fragment {

    EditText titol, autor, editNota;
    Spinner estat;
    TextView textNota;
    Button addButton;
    BooksModel bookModel;
    int booksPosition = -1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.reedbooks_fragment, container, false);

        titol = v.findViewById(R.id.title_edit_add);
        autor = v.findViewById(R.id.athor_edit_add);
        editNota = v.findViewById(R.id.note_edit_add);
        estat = v.findViewById(R.id.spinner_state_add);
        textNota = v.findViewById(R.id.note_add_text);
        addButton = v.findViewById(R.id.button_add);

        editNota.setVisibility(View.INVISIBLE);
        textNota.setVisibility(View.INVISIBLE);
        addButton.setText("ADD");

        estat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 2){
                    editNota.setVisibility(View.VISIBLE);
                    textNota.setVisibility(View.VISIBLE);
                }else{
                    editNota.setVisibility(View.INVISIBLE);
                    textNota.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        if(getArguments() != null){
            booksPosition = getArguments().getInt("booksModel");
            if(booksPosition > -1){
                addButton.setText("UP");
                bookModel = BooksViewModel.booksregister.get(booksPosition);
                titol.setText(bookModel.getTitol());
                autor.setText(bookModel.getAutor());
                estat.setSelection(bookModel.getEstat());
                if(bookModel.getNota() != 6)editNota.setText(String.valueOf(bookModel.getNota()));
            }
        }

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                if(!titol.getText().toString().equals("") && !autor.getText().toString().equals("")) {
                    bookModel = new BooksModel(titol.getText().toString(), autor.getText().toString(), estat.getSelectedItem().toString(), estat.getSelectedItemPosition(), 6);
                    if(editNota.getVisibility() == View.VISIBLE){
                        if(!editNota.getText().toString().equals("")) {
                            try {
                                int nota = Integer.parseInt(editNota.getText().toString());
                                if(nota >= 0 && nota <= 5){
                                    bookModel.setNota(nota);
                                    addBoks(v);
                                }else Toast.makeText(getContext(), "La nota ha de tenir un valor entre 0 i 5", Toast.LENGTH_SHORT).show();
                            } catch (NumberFormatException e) {
                                Toast.makeText(getContext(), "La nota te que ser un numero", Toast.LENGTH_SHORT).show();
                            }
                        }else Toast.makeText(getContext(), "Hi ha camps buits.", Toast.LENGTH_SHORT).show();
                    }else{
                        addBoks(v);
                    }
                }else Toast.makeText(getContext(), "Hi ha camps buits.", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

    public void addBoks(View v){
        if(booksPosition < 0){
            BooksViewModel.booksregister.add(bookModel);
            NavDirections directions = cat.itb.reedbooks.ReedbooksFragmentDirections.actionReedbooksFragmentToReedbooksListFragment2();
            Navigation.findNavController(v).navigate(directions);
        }else {
            BooksViewModel.booksregister.get(booksPosition).setTitol(bookModel.getTitol());
            BooksViewModel.booksregister.get(booksPosition).setAutor(bookModel.getAutor());
            BooksViewModel.booksregister.get(booksPosition).setEstat(bookModel.getEstat());
            BooksViewModel.booksregister.get(booksPosition).setEstatText(bookModel.getEstatText());
            BooksViewModel.booksregister.get(booksPosition).setNota(bookModel.getNota());
            NavDirections directions = cat.itb.reedbooks.ReedbooksFragmentDirections.actionReedbooksFragmentToReedbooksListFragment2();
            Navigation.findNavController(v).navigate(directions);
        }
    }
}
