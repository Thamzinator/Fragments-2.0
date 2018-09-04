package com.example.tcssi.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UnivList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_univ_list);

        recyclerView = findViewById(R.id.rv_univList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        ListItem uj = new ListItem(

                "University of Johannesburg",
                "Dornfontein campus"
        );

        listItems.add(uj);

        ListItem wits = new ListItem(

                "University of the Witwatersrand",
                "Dornfontein campus"
        );

        listItems.add(wits);

        ListItem uct = new ListItem(

                "University of Cape Town",
                "Dornfontein campus"
        );
        listItems.add(uct);

        ListItem ufh = new ListItem(

                "University of Fore Hare",
                "Dornfontein campus"
        );
        listItems.add(ufh);

        ListItem ufs = new ListItem(

                "University of the Free States",
                "Dornfontein campus"
        );
        listItems.add(ufs);

        ListItem ukzn = new ListItem(

                "University of KwaZulu-Natal",
                "Dornfontein campus"
        );
        listItems.add(ukzn);

        ListItem ul = new ListItem(

                "University of Limpopo",
                "Dornfontein campus"
        );
        listItems.add(ul);

        ListItem up = new ListItem(

                "University of Pretoria",
                "Dornfontein campus"
        );
        listItems.add(up);

        ListItem nwu = new ListItem(

                "North West University",
                "Dornfontein campus"
        );
        listItems.add(nwu);

        ListItem rhodes = new ListItem(

                "Rhodes University",
                "Dornfontein campus"
        );
        listItems.add(rhodes);

        ListItem stellie = new ListItem(

                "University of Stellenbosch",
                "Dornfontein campus"
        );
        listItems.add(stellie);

        ListItem wc = new ListItem(

                "University of Western Cape",
                "Dornfontein campus"
        );
        listItems.add(wc);

        ListItem nmmu = new ListItem(

                "Nelson Mandela Metro University",
                "Dornfontein campus"
        );
        listItems.add(nmmu);

        ListItem unisa = new ListItem(

                "University of South Africa",
                "Dornfontein campus"
        );
        listItems.add(unisa);

        ListItem venda = new ListItem(

                "University of Venda",
                "Dornfontein campus"
        );
        listItems.add(venda);

        ListItem wsu = new ListItem(

                "Walter Sisulu University",
                "Dornfontein campus"
        );
        listItems.add(wsu);

        ListItem zulu = new ListItem(

                "University of Zululand",
                "Dornfontein campus"
        );
        listItems.add(zulu);

        ListItem cput = new ListItem(

                "Vaal university of Technology",
                "Dornfontein campus"
        );
        listItems.add(cput);

        ListItem tut = new ListItem(

                "Tswane Univiersity of Technology",
                "Dornfontein campus"
        );
        listItems.add(tut);

        ListItem smu = new ListItem(

                "Walter Sisulu University",
                "Dornfontein campus"
        );
        listItems.add(smu);

        ListItem med = new ListItem(

                "Medunsa",
                "Dornfontein campus"
        );
        listItems.add(med);

        ListItem ump = new ListItem(

                "University of Mpumalanga",
                "Dornfontein campus"
        );
        listItems.add(ump);

        adapter = new UnivAdapter(listItems, this);

        recyclerView.setAdapter(adapter);
    }
}
