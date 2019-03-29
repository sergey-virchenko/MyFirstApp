package com.sit.myfirstapp.lists;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sit.myfirstapp.R;

import java.util.ArrayList;

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.ViewHolder> {

    public interface OnStudentClickListener {
        void onStudentClick(Student student);
    }

    private ArrayList<Student> students;
    private OnStudentClickListener onStudentClickListener;

    public void setOnStudentClickListener(OnStudentClickListener onStudentClickListener) {
        this.onStudentClickListener = onStudentClickListener;
    }

    public StudentListAdapter(ArrayList<Student> students) {
        this.students = students;
    }

    public void notifyData(ArrayList<Student> students) {
        this.students = students;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int itemViewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_student, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Student student = students.get(position);
        viewHolder.age.setText(String.valueOf(student.age));
        viewHolder.name.setText(student.name);
        viewHolder.itemView.setOnClickListener(v -> onStudentClickListener.onStudentClick(student));
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView age;
        public TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            age = itemView.findViewById(R.id.student_age);
            name = itemView.findViewById(R.id.student_name);
        }
    }
}
