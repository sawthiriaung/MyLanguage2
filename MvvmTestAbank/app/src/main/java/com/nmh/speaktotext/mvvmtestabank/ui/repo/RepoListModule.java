package com.nmh.speaktotext.mvvmtestabank.ui.repo;

import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class RepoListModule {

    @Provides
    RepoListAdapter provideAdapter() {
        return new RepoListAdapter(new ArrayList<>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(RepoListActivity repoListActivity) {
        return new LinearLayoutManager(repoListActivity);
    }
}
