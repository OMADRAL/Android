package com.example.appiagi2_26;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class listeVille extends AppCompatActivity {

    private RecyclerView recyclerView;
    private VilleAdapter adapter;
    private List<Ville> listeVilles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_liste_ville);

        // Gestion des Insets (barres système) - Doit être dans onCreate
        // Assure-toi que l'ID de ton layout racine dans activity_liste_ville.xml est bien "main"
        View rootLayout = findViewById(R.id.main);
        if (rootLayout != null) {
            ViewCompat.setOnApplyWindowInsetsListener(rootLayout, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        // 1. Initialisation des données
        listeVilles = new ArrayList<>();
        listeVilles.add(new Ville("Fes", "Capitale spirituelle", R.drawable.fes));
        listeVilles.add(new Ville("Casablanca", "Capitale économique", R.drawable.casa));
        listeVilles.add(new Ville("Ouarzazat", "Porte du désert", R.drawable.ouarzazat));
        listeVilles.add(new Ville("Marrakech", "La ville ocre", R.drawable.marrakech));
        listeVilles.add(new Ville("Chefchaoun", "La ville bleue", R.drawable.chefchaoun));
        listeVilles.add(new Ville("Tetouan", "La colombe blanche", R.drawable.tetouan));
        listeVilles.add(new Ville("Fes", "Capitale spirituelle", R.drawable.fes));
        listeVilles.add(new Ville("Casablanca", "Capitale économique", R.drawable.casa));
        listeVilles.add(new Ville("Ouarzazat", "Porte du désert", R.drawable.ouarzazat));
        listeVilles.add(new Ville("Marrakech", "La ville ocre", R.drawable.marrakech));
        listeVilles.add(new Ville("Chefchaoun", "La ville bleue", R.drawable.chefchaoun));
        listeVilles.add(new Ville("Tetouan", "La colombe blanche", R.drawable.tetouan));


        // 2. Configuration du RecyclerView
        recyclerView = findViewById(R.id.recyclerViewVilles);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new VilleAdapter(listeVilles);
        recyclerView.setAdapter(adapter);
        // --- ACTION DU BOUTON AJOUTER ---
        Button btnAdd = findViewById(R.id.btnAjouterVille);
        btnAdd.setOnClickListener(v -> {
            // On crée un petit formulaire rapide
            EditText inputNom = new EditText(this);
            inputNom.setHint("Nom de la ville");

            new AlertDialog.Builder(this)
                    .setTitle("Ajouter une ville")
                    .setMessage("Entrez le nom de la ville :")
                    .setView(inputNom)
                    .setPositiveButton("Ajouter", (dialog, which) -> {
                        String nom = inputNom.getText().toString();
                        if (!nom.isEmpty()) {
                            // On ajoute à la liste (on utilise l'image Marrakech par défaut)
                            listeVilles.add(new Ville(nom, "Nouvelle ville ajoutée", R.drawable.marrakech));
                            // On prévient l'adapter que les données ont changé
                            adapter.notifyDataSetChanged();
                        }
                    })
                    .setNegativeButton("Annuler", null)
                    .show();
        });
    }

    // --- CLASSE MODELE ---
    class Ville {
        String nom, desc;
        int image;
        Ville(String n, String d, int i) { this.nom = n; this.desc = d; this.image = i; }
    }

    // --- ADAPTER ---
    class VilleAdapter extends RecyclerView.Adapter<VilleAdapter.MyViewHolder> {
        List<Ville> data;
        VilleAdapter(List<Ville> d) { this.data = d; }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ville, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            Ville v = data.get(position);
            holder.nom.setText(v.nom);
            holder.desc.setText(v.desc);
            holder.img.setImageResource(v.image);

            // CRUD: MODIFIER (Clic simple)
            holder.itemView.setOnClickListener(view -> {
                EditText input = new EditText(listeVille.this);
                input.setText(v.nom);
                new AlertDialog.Builder(listeVille.this)
                        .setTitle("Modifier la ville")
                        .setView(input)
                        .setPositiveButton("Ok", (dialog, i) -> {
                            v.nom = input.getText().toString();
                            notifyItemChanged(position);
                        }).show();
            });

            // CRUD: SUPPRIMER (Clic long)
            holder.itemView.setOnLongClickListener(view -> {
                new AlertDialog.Builder(listeVille.this)
                        .setTitle("Supprimer ?")
                        .setMessage("Voulez-vous supprimer " + v.nom + " ?")
                        .setPositiveButton("Oui", (dialog, i) -> {
                            data.remove(position);
                            notifyItemRemoved(position);
                            notifyItemRangeChanged(position, data.size());
                        }).setNegativeButton("Non", null).show();
                return true;
            });
        }

        @Override
        public int getItemCount() { return data.size(); }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView nom, desc;
            ImageView img;
            MyViewHolder(View v) {
                super(v);
                nom = v.findViewById(R.id.txtNom);
                desc = v.findViewById(R.id.txtDesc);
                img = v.findViewById(R.id.imgVille);
            }
        }
    }
}

