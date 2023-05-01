package com.example.prac2;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class ThirdFragment extends Fragment {

    private static final String TAG = "ThirdFragment";
    public ThirdFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    private String[] news_names = new String[]{
            "Тут победили",
            "Тут проиграли",
            "Тут ничего не было",
            "Правительство запустило хакатон",
            "Айтишникам отсрочка"
    };

    private ListView listView1;
    private int[] icons = new int[]{
            R.drawable.dollar,
            R.drawable.heart,
            R.drawable.rainbow,
            R.drawable.star,
            R.drawable.idk
    };
    RecyclerView recView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toast.makeText(getContext(), "onViewCreated", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onViewCreated");

        Bundle bundle = this.getArguments();
        TextView textView = getView().findViewById(R.id.hackstext);
        String result = bundle.getString("data");
        textView.setText(result);

        recView = getView().findViewById(R.id.news_list);
        recView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recView.setLayoutManager(layoutManager);
        adapter = new NewsAdapter(getActivity(), icons, news_names);
        recView.setAdapter(adapter);

        Button go_back = getView().findViewById(R.id.go_back);
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Переход к прошлой странице");
                Navigation.findNavController(view).navigate(R.id.action_thirdFragment_to_firstFragment);

            }
        });
    }



}