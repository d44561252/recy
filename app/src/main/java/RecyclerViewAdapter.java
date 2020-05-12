import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<String> mListString;
    public class  ViewHolder extends RecyclerView.ViewHolder
                  implements View.OnClickListener{
        public ImageView mImgView;
        public TextView mTxt;

        public ViewHolder(View itemView){
            super(itemView);
            mImgView =(ImageView) itemView.findViewById(R.id.imgView);
            mTxt =(TextView) itemView.findViewById(R.id.txt);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view){
            Toast.makeText(view.getContext(),
                    mListString.get(getAdapterPosition()), Toast.LENGTH_LONG)
                    .show();
        }
    }

    public  RecyclerViewAdapter(List<String> listString){
        mListString =listString;
    }
    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(
                   @NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_item, viewGroup,false);
        ViewHolder viewHolder =new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(
            @NonNull ViewHolder viewHolder, int i) {
        viewHolder.mImgView.setImageResource(android.R.drawable.star_on);
        viewHolder.mTxt.setText(mListString.get(i));

    }

    @Override
    public int getItemCount() {
        return mListString.size();
    }
}
