package com.nmh.speaktotext.mvvmtestabank.utils;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.nmh.speaktotext.mvvmtestabank.model.Repository;
import com.nmh.speaktotext.mvvmtestabank.ui.repo.RepoListAdapter;

import java.util.List;

public class BindingUtils {

    private BindingUtils() {
        // This class is not publicly instantiable
    }

    @BindingAdapter({"adapter"})
    public static void addRepoItems(RecyclerView recyclerView, List<Repository> repoList) {
        RepoListAdapter adapter = (RepoListAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(repoList);
        }
    }
}
