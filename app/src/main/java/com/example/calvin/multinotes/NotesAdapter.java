package com.example.calvin.multinotes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<Note> noteList;
    private MainActivity mainAct;

    public NotesAdapter(List<Note> noteList, MainActivity ma){
        this.noteList = noteList;
        mainAct = ma;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.note_list_row, viewGroup, false);
        itemView.setOnClickListener(mainAct);
        itemView.setOnLongClickListener(mainAct);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Note note = noteList.get(i);
        myViewHolder.title.setText(note.getTitle());
        myViewHolder.time.setText(note.getTime());
        myViewHolder.content.setText(note.getContent());
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }
}
