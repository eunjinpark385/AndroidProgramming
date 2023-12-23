package com.example.diaryapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diaryapplication.databinding.NoteItemBinding;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    Context context;
    Vector<Note> items;
    TextView tvCategory, tvTitle, tvContent;
    EditText edCategory, edTitle, edContent;

    // Constructor
    NoteAdapter(Context context, Vector<Note> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        NoteItemBinding binding = NoteItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Note item = items.get(position);
        holder.binding.tvCategory.setText(item.category);
        holder.binding.tvTitle.setText(item.title);
        holder.binding.tvContent.setText(item.contents);
        holder.binding.tvDate.setText(item.createDateStr);

        // Note 객체를 선택 -> 메모 내용 수정할 수 있는 Dialog 띄움
        holder.binding.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Dialog 객체 생성 및 제목 설정
                View dialogView = (View) View.inflate(context, R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(context);
                dlg.setTitle(R.string.dlg_title);
                // User 가 Dialog 에 입력한 정보 가져 오기 (Category, Title, Content)
                edCategory = (EditText) dialogView.findViewById(R.id.dlg_ed_category);
                edTitle = (EditText) dialogView.findViewById(R.id.dlg_ed_Title);
                edContent = (EditText) dialogView.findViewById(R.id.dlg_ed_Content);
                // Dialog 의 확인 버튼 클릭 하면 변경 내용 적용
                dlg.setPositiveButton(R.string.dlg_btn, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
                        Date date = new Date();
                        // View 내용 변경
                        holder.binding.tvCategory.setText(edCategory.getText().toString());
                        holder.binding.tvTitle.setText(edTitle.getText().toString());
                        holder.binding.tvContent.setText(edContent.getText().toString());
                        holder.binding.tvDate.setText(formatter.format(date));
                        // Note 객체 값 갱신
                        item.setCategory(edCategory.getText().toString());
                        item.setTitle(edTitle.getText().toString());
                        item.setContents(edContent.getText().toString());
                        item.setCreateDateStr(formatter.format(date));
                    }
                });
                // Dialog 보이기
                dlg.setView(dialogView);
                dlg.setNegativeButton(R.string.btn_close, null);
                dlg.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        NoteItemBinding binding;

        public ViewHolder(@NonNull NoteItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}