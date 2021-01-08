package cat.itb.reedbooks;

import android.os.Parcel;
import android.os.Parcelable;

public class BooksModel implements Parcelable {
    private String titol, autor, estatText;
    private int estat, nota;

    public BooksModel(String titol, String autor, String estatText, int estat, int nota) {
        this.titol = titol;
        this.autor = autor;
        this.estatText = estatText;
        this.estat = estat;
        this.nota = nota;
    }

    protected BooksModel(Parcel in) {
        titol = in.readString();
        autor = in.readString();
        estatText = in.readString();
        estat = in.readInt();
        nota = in.readInt();
    }

    public static final Creator<BooksModel> CREATOR = new Creator<BooksModel>() {
        @Override
        public BooksModel createFromParcel(Parcel in) {
            return new BooksModel(in);
        }

        @Override
        public BooksModel[] newArray(int size) {
            return new BooksModel[size];
        }
    };

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getEstat() {
        return estat;
    }

    public void setEstat(int estat) {
        this.estat = estat;
    }

    public String getEstatText() {
        return estatText;
    }

    public void setEstatText(String estatText) {
        this.estatText = estatText;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titol);
        dest.writeString(autor);
        dest.writeString(estatText);
        dest.writeInt(estat);
        dest.writeInt(nota);
    }
}
