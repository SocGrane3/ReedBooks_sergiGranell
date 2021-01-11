package cat.itb.reedbooks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ReedbooksListFragment extends Fragment {

    RecyclerView recyclerView;
    Button addButton;
    BooksAdapter adapter;
    BooksViewModel booksViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        booksViewModel = new ViewModelProvider(this).get(BooksViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.reedbooks_list_fragment, container, false);

        addButton = v.findViewById(R.id.button_add_list);
        recyclerView = v.findViewById(R.id.recyclerView);

        adapter = new BooksAdapter(BooksViewModel.booksregister);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               NavDirections directions = cat.itb.reedbooks.ReedbooksListFragmentDirections.actionReedbooksListFragmentToReedbooksFragment(-1);
               Navigation.findNavController(v).navigate(directions);
            }
        });
        return v;
    }
}
