package com.example.contactslisttest;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CursorRecyclerviewAdapter extends BaseCursorAdapter<CursorRecyclerviewAdapter.ContactViewHolder> {


    public CursorRecyclerviewAdapter() {
        super(null);
    }

    @Override
    public void swapCursor(Cursor newCursor) {
        super.swapCursor(newCursor);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, Cursor cursor) {
        int columnIndexName = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);

        String contactName = cursor.getString(columnIndexName);

        contactViewHolder.name.setText(contactName);
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContactViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent, false));
    }

    class ContactViewHolder extends RecyclerView.ViewHolder{

        TextView name;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
        }
    }
}
