package cat.itb.reedbooks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BooksViewHolder>{
    ArrayList<BooksModel> booksRegister;

    public BooksAdapter(ArrayList<BooksModel> booksRegister) {
        this.booksRegister = booksRegister;
    }

    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.reedbooks_list_item, parent, false);

        return new BooksViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksViewHolder holder, int position) {
        holder.bindData(booksRegister.get(position));
    }

    @Override
    public int getItemCount() {
        return booksRegister.size();
    }

    class BooksViewHolder extends RecyclerView.ViewHolder{
        TextView titol, autor, estat, nota, notaTitol;


        public BooksViewHolder(@NonNull View itemView) {
            super(itemView);

            titol = itemView.findViewById(R.id.atribut_titel);
            autor = itemView.findViewById(R.id.atribut_athor);
            estat = itemView.findViewById(R.id.atribut_state);
            nota = itemView.findViewById(R.id.atribut_note);
            notaTitol = itemView.findViewById(R.id.note_text);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NavDirections directions = cat.itb.reedbooks.ReedbooksListFragmentDirections.actionReedbooksListFragmentToReedbooksFragment(getAdapterPosition());
                    Navigation.findNavController(v).navigate(directions);
                }
            });
        }

        public void bindData(BooksModel bookModel){
            titol.setText(bookModel.getTitol());
            autor.setText(bookModel.getAutor());
            estat.setText(bookModel.getEstatText());
            if(bookModel.getNota()>5){
                nota.setVisibility(View.INVISIBLE);
                notaTitol.setVisibility(View.INVISIBLE);
            }
            else{
                nota.setText(String.valueOf(bookModel.getNota()));
            }
        }
    }
}
