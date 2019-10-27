package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.events.FavoriteNeighbourEvent;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailNeighbour extends AppCompatActivity {
    private Neighbour mNeighbour;
    private NeighbourApiService mNeighbourApiService;
    @BindView(R.id.avatar)
    ImageView mAvatar;
    @BindView(R.id.name_1)
    TextView mName;
    @BindView(R.id.name_2)
    TextView mScndName;
    @BindView(R.id.adresse)
    TextView mAdresse;
    @BindView(R.id.num_phone)
    TextView mPhoneNumber;
    @BindView(R.id.facebook)
    TextView mFacebook;
    @BindView(R.id.description)
    TextView mDescription;
    @BindView(R.id.btn_favorite)
    FloatingActionButton mFavoriteButton;
    @BindView(R.id.back_btn)
    Button mBackButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_neighbour);
        ButterKnife.bind(this);
        mNeighbourApiService = DI.getNeighbourApiService();

        int idNeighbour = getIntent().getIntExtra("idNeighbour", 0);
        mNeighbour = mNeighbourApiService.getNeighbour(idNeighbour);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailNeighbour.this.finish();
            }
        });
        mName.setText(mNeighbour.getName());
        mScndName.setText(mNeighbour.getName());
        mAdresse.setText(mNeighbour.getAddress() + " à " + mNeighbour.getDistance() + " km");
        mPhoneNumber.setText(mNeighbour.getPhoneNumber());
        mFacebook.setText(mNeighbour.getFacebook());
        mDescription.setText(mNeighbour.getDescription());
        String avatarUrl = mNeighbour.getAvatarUrl();
        Glide.with(this).load(avatarUrl).into(mAvatar);

        mFavoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EventBus.getDefault().postSticky(new FavoriteNeighbourEvent(mNeighbour));

                ColorFavoriteButton();
            }
        });

    }
    // method color favorite button
    private void ColorFavoriteButton() {

        if (mNeighbour.isFavorite()) {
            mFavoriteButton.setColorFilter(Color.YELLOW);
        } else {
            mFavoriteButton.setColorFilter(Color.LTGRAY);
        }
    }

}
