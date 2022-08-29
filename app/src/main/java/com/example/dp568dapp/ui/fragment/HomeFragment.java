package com.example.dp568dapp.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dp568dapp.R;
import com.example.dp568dapp.model.Post;
import com.example.dp568dapp.ui.adapter.KingOfPostAdapter;
import com.example.dp568dapp.ui.adapter.PostAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements KingOfPostAdapter.UpdateRecyclerView {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private KingOfPostAdapter kingOfPostAdapter;
    private EditText etSearch;
    private RecyclerView recyclerviewKingOf;
    private TextView tvSeeMoerGanNhat;
    private RecyclerView recyclerviewNews;
    private TextView tvSeeMoreListChinh;
    private RecyclerView recyclerviewFeedBack;
    private List<String> listKingOfPost;
    private PostAdapter postAdapter;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        etSearch = (EditText) view.findViewById(R.id.etSearch);
        recyclerviewKingOf = (RecyclerView) view.findViewById(R.id.recyclerviewKingOf);
        tvSeeMoerGanNhat = (TextView) view.findViewById(R.id.tvSeeMoerGanNhat);
        recyclerviewNews = (RecyclerView) view.findViewById(R.id.recyclerviewNews);
        tvSeeMoreListChinh = (TextView) view.findViewById(R.id.tvSeeMoreListChinh);
        recyclerviewFeedBack = (RecyclerView) view.findViewById(R.id.recyclerviewFeedBack);
        listKingOfPost = new ArrayList<>();
        listKingOfPost.add("Trang chủ");
        listKingOfPost.add("Thể thao");
        listKingOfPost.add("Casino");
        listKingOfPost.add("Đá gà");
        listKingOfPost.add("Nổ hũ");
        listKingOfPost.add("Xổ số");
        kingOfPostAdapter = new KingOfPostAdapter(listKingOfPost, this);
        recyclerviewKingOf.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerviewKingOf.setAdapter(kingOfPostAdapter);
    }

    @Override
    public void callbacksChanged(int position, List<Post> list) {
        postAdapter = new PostAdapter(list);
        recyclerviewNews.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerviewNews.setAdapter(postAdapter);
    }

    @Override
    public void callbacksChanged2(int position, List<Post> list) {

    }
}