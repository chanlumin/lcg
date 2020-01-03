package top.easelink.lcg.ui.main.forumnav.view;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kunminx.linkage.LinkageRecyclerView;
import com.kunminx.linkage.bean.DefaultGroupedItem;

import java.util.List;

import top.easelink.framework.base.BaseFragment;
import top.easelink.lcg.BR;
import top.easelink.lcg.R;
import top.easelink.lcg.databinding.FragmentForumsNavigationV2Binding;
import top.easelink.lcg.ui.main.forumnav.viewmodel.ForumNavigationViewModel;

public class ForumNavigationV2Fragment extends BaseFragment<FragmentForumsNavigationV2Binding, ViewModel> {
    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_forums_navigation_v2;
    }

    @Override
    public ForumNavigationViewModel getViewModel() {
        return null;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        initLinkageDatas(getViewDataBinding().linkage);
    }

    @SuppressWarnings("unchecked")
    private void initLinkageDatas(LinkageRecyclerView linkage) {
        Gson gson = new Gson();
        List<DefaultGroupedItem> items = gson.fromJson(getString(R.string.test_json),
                new TypeToken<List<DefaultGroupedItem>>() {}.getType());

        linkage.init(items);
        linkage.setDefaultOnItemBindListener(
                null,
                null,
                (secondaryHolder, item) ->
                        secondaryHolder.getView(R.id.level_2_item).setOnClickListener(v -> {
                            Snackbar.make(v, item.info.getTitle(), Snackbar.LENGTH_SHORT).show();
                        }),
                null,
                null
        );
    }

    public static ForumNavigationV2Fragment newInstance() {
        return new ForumNavigationV2Fragment();
    }
}
