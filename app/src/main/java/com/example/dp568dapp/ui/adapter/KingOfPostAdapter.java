package com.example.dp568dapp.ui.adapter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dp568dapp.R;
import com.example.dp568dapp.model.Post;

import java.util.ArrayList;
import java.util.List;

public class KingOfPostAdapter extends RecyclerView.Adapter<KingOfPostAdapter.ViewHolder> {
    private int row_index = -1;
    public static int index = 1;
    private boolean selected = true;
    private boolean check = true;
    private List<String> listKingOfPost;
    private List<Post> listPost;
    private List<Post> listPostFeedBack;
    private UpdateRecyclerView mUpdateRecyclerView;

    public KingOfPostAdapter(List<String> listKingOfPost, UpdateRecyclerView mUpdateRecyclerView) {
        this.listKingOfPost = listKingOfPost;
        this.mUpdateRecyclerView = mUpdateRecyclerView;
    }

    public interface UpdateRecyclerView {
        public void callbacksChanged(int position, List<Post> list);

        public void callbacksChanged2(int position, List<Post> list);
    }

    @NonNull
    @Override
    public KingOfPostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kingofpost, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KingOfPostAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String nameKingOfPost = listKingOfPost.get(position);
        holder.name.setText(nameKingOfPost);
        holder.name.setTypeface(holder.name.getTypeface(), Typeface.NORMAL);
        holder.name.getPaint().setUnderlineText(false);
        if (check) {
            listPost = new ArrayList<>();
            listPost.add(new Post(1, "CHIẾN THUẬT NHÀ CÁI KINGBET CHƠI POKER Ở BÀN NHIỀU NGƯỜI CHƠI LOOSE", "Casino", "Một Tay bài Poker (Poker Hands) kingbet sẽ luôn được tạo thành bởi 5 lá bài tốt nhất. Các bạn sẽ chỉ giữ được 2 lá trên tay, và sử dụng được chúng để có thể kết hợp với 5 lá bài chung ở trên bàn để cấu tạo 1 Tay bài poker mạnh nhất.  Có cực nhiều anh em vẫn sẽ còn đang nhầm lẫn trong việc đọ bài dẫn đến một số điểm sai sót nghiêm trọng trong chiến thuật chơi của mình.\n" +
                    "\n" +
                    "Khác với các loại game bài khác, thay vì phần nhiều sẽ được dựa vào sự may mắn thì cách chơi Poker Us sẽ là nơi để các bạn có thể miêu tả về trí não trong từng chiến thuật chơi. Trong cách chơi Poker Us thì việc xác định được kết quả thắng thua ở mỗi ván bài Poker sẽ được dựa vào thứ hạng của các Tay bài. Tóm lại người chơi sẽ có 3 nhóm hành động chính gồm: Fold, Check/call, Bet/raise. Vòng đặt cược kết thúc là lúc mọi người chơi đã đều call hoặc là sẽ check hay fold bài. Tuy nói đơn giản nhưng có rất nhiều người chơi nắm được cho mình cách chơi Poker US như thế nào. Dưới đây chúng tôi sẽ giúp bạn đi tìm hiểu về loại hình Poker này tại các casino online uy tín nhất.", 20, R.drawable.imagefake));
            listPost.add(new Post(1, "POKER US KINGBET CÓ ĐẶC ĐIỂM NHƯ THẾ NÀO? CÁCH CHƠI POKER US DỄ HIỂU NHẤT", "Casino", "Một Tay bài Poker (Poker Hands) kingbet sẽ luôn được tạo thành bởi 5 lá bài tốt nhất. Các bạn sẽ chỉ giữ được 2 lá trên tay, và sử dụng được chúng để có thể kết hợp với 5 lá bài chung ở trên bàn để cấu tạo 1 Tay bài poker mạnh nhất.  Có cực nhiều anh em vẫn sẽ còn đang nhầm lẫn trong việc đọ bài dẫn đến một số điểm sai sót nghiêm trọng trong chiến thuật chơi của mình.\n" +
                    "\n" +
                    "Khác với các loại game bài khác, thay vì phần nhiều sẽ được dựa vào sự may mắn thì cách chơi Poker Us sẽ là nơi để các bạn có thể miêu tả về trí não trong từng chiến thuật chơi. Trong cách chơi Poker Us thì việc xác định được kết quả thắng thua ở mỗi ván bài Poker sẽ được dựa vào thứ hạng của các Tay bài. Tóm lại người chơi sẽ có 3 nhóm hành động chính gồm: Fold, Check/call, Bet/raise. Vòng đặt cược kết thúc là lúc mọi người chơi đã đều call hoặc là sẽ check hay fold bài. Tuy nói đơn giản nhưng có rất nhiều người chơi nắm được cho mình cách chơi Poker US như thế nào. Dưới đây chúng tôi sẽ giúp bạn đi tìm hiểu về loại hình Poker này tại các casino online uy tín nhất.", 20, R.drawable.imagefake));
            listPost.add(new Post(1, "POKER US KINGBET CÓ ĐẶC ĐIỂM NHƯ THẾ NÀO? CÁCH CHƠI POKER US DỄ HIỂU NHẤT", "Casino", "Một Tay bài Poker (Poker Hands) kingbet sẽ luôn được tạo thành bởi 5 lá bài tốt nhất. Các bạn sẽ chỉ giữ được 2 lá trên tay, và sử dụng được chúng để có thể kết hợp với 5 lá bài chung ở trên bàn để cấu tạo 1 Tay bài poker mạnh nhất.  Có cực nhiều anh em vẫn sẽ còn đang nhầm lẫn trong việc đọ bài dẫn đến một số điểm sai sót nghiêm trọng trong chiến thuật chơi của mình.\n" +
                    "\n" +
                    "Khác với các loại game bài khác, thay vì phần nhiều sẽ được dựa vào sự may mắn thì cách chơi Poker Us sẽ là nơi để các bạn có thể miêu tả về trí não trong từng chiến thuật chơi. Trong cách chơi Poker Us thì việc xác định được kết quả thắng thua ở mỗi ván bài Poker sẽ được dựa vào thứ hạng của các Tay bài. Tóm lại người chơi sẽ có 3 nhóm hành động chính gồm: Fold, Check/call, Bet/raise. Vòng đặt cược kết thúc là lúc mọi người chơi đã đều call hoặc là sẽ check hay fold bài. Tuy nói đơn giản nhưng có rất nhiều người chơi nắm được cho mình cách chơi Poker US như thế nào. Dưới đây chúng tôi sẽ giúp bạn đi tìm hiểu về loại hình Poker này tại các casino online uy tín nhất.", 20, R.drawable.imagefake));
            listPost.add(new Post(1, "POKER US KINGBET CÓ ĐẶC ĐIỂM NHƯ THẾ NÀO? CÁCH CHƠI POKER US DỄ HIỂU NHẤT", "Casino", "Kinh nghiệm chơi đá gà online nhà cái king bet không nhà cái nào muốn bạn biết", 20, R.drawable.imagefake));
            listPost.add(new Post(1, "POKER US KINGBET CÓ ĐẶC ĐIỂM NHƯ THẾ NÀO? CÁCH CHƠI POKER US DỄ HIỂU NHẤT", "Casino", "Một Tay bài Poker (Poker Hands) kingbet sẽ luôn được tạo thành bởi 5 lá bài tốt nhất. Các bạn sẽ chỉ giữ được 2 lá trên tay, và sử dụng được chúng để có thể kết hợp với 5 lá bài chung ở trên bàn để cấu tạo 1 Tay bài poker mạnh nhất.  Có cực nhiều anh em vẫn sẽ còn đang nhầm lẫn trong việc đọ bài dẫn đến một số điểm sai sót nghiêm trọng trong chiến thuật chơi của mình.\n" +
                    "\n" +
                    "Khác với các loại game bài khác, thay vì phần nhiều sẽ được dựa vào sự may mắn thì cách chơi Poker Us sẽ là nơi để các bạn có thể miêu tả về trí não trong từng chiến thuật chơi. Trong cách chơi Poker Us thì việc xác định được kết quả thắng thua ở mỗi ván bài Poker sẽ được dựa vào thứ hạng của các Tay bài. Tóm lại người chơi sẽ có 3 nhóm hành động chính gồm: Fold, Check/call, Bet/raise. Vòng đặt cược kết thúc là lúc mọi người chơi đã đều call hoặc là sẽ check hay fold bài. Tuy nói đơn giản nhưng có rất nhiều người chơi nắm được cho mình cách chơi Poker US như thế nào. Dưới đây chúng tôi sẽ giúp bạn đi tìm hiểu về loại hình Poker này tại các casino online uy tín nhất.", 20, R.drawable.imagefake));
            listPost.add(new Post(1, "POKER US KINGBET CÓ ĐẶC ĐIỂM NHƯ THẾ NÀO? CÁCH CHƠI POKER US DỄ HIỂU NHẤT", "Casino", "Một Tay bài Poker (Poker Hands) kingbet sẽ luôn được tạo thành bởi 5 lá bài tốt nhất. Các bạn sẽ chỉ giữ được 2 lá trên tay, và sử dụng được chúng để có thể kết hợp với 5 lá bài chung ở trên bàn để cấu tạo 1 Tay bài poker mạnh nhất.  Có cực nhiều anh em vẫn sẽ còn đang nhầm lẫn trong việc đọ bài dẫn đến một số điểm sai sót nghiêm trọng trong chiến thuật chơi của mình.\n" +
                    "\n" +
                    "Khác với các loại game bài khác, thay vì phần nhiều sẽ được dựa vào sự may mắn thì cách chơi Poker Us sẽ là nơi để các bạn có thể miêu tả về trí não trong từng chiến thuật chơi. Trong cách chơi Poker Us thì việc xác định được kết quả thắng thua ở mỗi ván bài Poker sẽ được dựa vào thứ hạng của các Tay bài. Tóm lại người chơi sẽ có 3 nhóm hành động chính gồm: Fold, Check/call, Bet/raise. Vòng đặt cược kết thúc là lúc mọi người chơi đã đều call hoặc là sẽ check hay fold bài. Tuy nói đơn giản nhưng có rất nhiều người chơi nắm được cho mình cách chơi Poker US như thế nào. Dưới đây chúng tôi sẽ giúp bạn đi tìm hiểu về loại hình Poker này tại các casino online uy tín nhất.", 20, R.drawable.imagefake));
            mUpdateRecyclerView.callbacksChanged(position, listPost);
            check = false;
        }
        holder.itemView.setOnClickListener(v -> {
            row_index = position;
            notifyDataSetChanged();
            if (position == 0) {
                index = 1;
            } else if (position == 1) {
                index = 2;
            } else if (position == 2) {
                index = 3;
            } else if (position == 3) {
                index = 4;
            } else if (position == 4) {
                index = 5;
            } else if (position == 5) {
                index = 6;
            }
        });
        if (selected) {
            if (position == 0) {
                holder.name.setTextColor(holder.name.getContext().getResources().getColor(R.color.black));
                holder.name.setTextSize(20);
                holder.name.setTypeface(holder.name.getTypeface(), Typeface.BOLD);
                holder.name.getPaint().setUnderlineText(true);
            }
            selected = false;
        } else {
            if (row_index == position) {
                holder.name.setTextColor(holder.name.getContext().getResources().getColor(R.color.black));
                holder.name.setTextSize(20);
                holder.name.setTypeface(holder.name.getTypeface(), Typeface.BOLD);
                holder.name.getPaint().setUnderlineText(true);
            } else {
                holder.name.setTextColor(holder.name.getContext().getResources().getColor(R.color.color_text_item_unclick));
                holder.name.setTextSize(14);
                holder.name.setTypeface(holder.name.getTypeface(), Typeface.NORMAL);
                holder.name.getPaint().setUnderlineText(false);
            }
        }
    }

    @Override
    public int getItemCount() {
        return listKingOfPost == null ? 0 : listKingOfPost.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
        }
    }
}
