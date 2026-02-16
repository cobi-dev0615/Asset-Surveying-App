package com.google.zxing.client.android.book;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import barcodescanner.xservices.nl.barcodescanner.R;
import java.util.List;

/* loaded from: classes.dex */
final class SearchBookContentsAdapter extends ArrayAdapter<SearchBookContentsResult> {
    SearchBookContentsAdapter(Context context, List<SearchBookContentsResult> list) {
        super(context, R.layout.search_book_contents_list_item, 0, list);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        SearchBookContentsListItem searchBookContentsListItem;
        if (view == null) {
            searchBookContentsListItem = (SearchBookContentsListItem) LayoutInflater.from(getContext()).inflate(R.layout.search_book_contents_list_item, viewGroup, false);
        } else {
            boolean z = view instanceof SearchBookContentsListItem;
            view2 = view;
            if (z) {
                searchBookContentsListItem = (SearchBookContentsListItem) view;
            }
            return view2;
        }
        searchBookContentsListItem.set(getItem(i));
        view2 = searchBookContentsListItem;
        return view2;
    }
}
