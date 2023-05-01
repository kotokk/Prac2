package com.example.prac2;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondFragment extends Fragment {

    private static final String TAG = "SecondFragment";
    public SecondFragment() {    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private String[] hacks_names = new String[]{
            "Неинтересная фигня",
            "Опять бигдата",
            "Машин-лёрнинг для смелых",
            "Нишевая штука",
            "Богатый спонсор",
            "Сюда никто не запишется",
            "Сюда запишется каждый второй"
    };

    private ListView listView1;
    private Integer[] icons = new Integer[]{
            R.drawable.dollar,
            R.drawable.heart,
            R.drawable.rainbow,
            R.drawable.star,
            R.drawable.idk,

    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toast.makeText(getContext(), "onViewCreated", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onViewCreated");

        int random_number;
        ArrayList<HacksList> hacks = new ArrayList<>();
        listView1 = getView().findViewById(R.id.hacks_lv);

        for(int i = 0; i <= 99; i++){
            random_number = (int) (Math.random() * (5));
            hacks.add(new HacksList(icons[random_number],hacks_names[random_number]));
        }
        HacksAdapter ha = new HacksAdapter(getActivity(), R.layout.list_view, hacks);
        listView1.setAdapter(ha);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int pos = position + 1;
                Log.i(TAG, "Нажат " + pos + " элемент");
                Toast.makeText(getActivity(), "Нажат " + pos + " элемент", Toast.LENGTH_SHORT).show();
            }
        });

        Button goback = getView().findViewById(R.id.go_back);
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Переход к прошлой странице");
                Navigation.findNavController(view).navigate(R.id.action_secondFragment_to_firstFragment);
            }
        });
    }

}