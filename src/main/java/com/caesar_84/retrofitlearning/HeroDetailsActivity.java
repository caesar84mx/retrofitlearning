package com.caesar_84.retrofitlearning;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.caesar_84.retrofitlearning.model.Hero;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HeroDetailsActivity extends AppCompatActivity {
    @BindView(R.id.ivAvatar)
    ImageView ivAvatar;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvRealName)
    TextView tvRealName;
    @BindView(R.id.tvTeam)
    TextView tvTeam;
    @BindView(R.id.tvFirstAppeared)
    TextView tvFirstAppeared;
    @BindView(R.id.tvCreatedBy)
    TextView tvCreatedBy;
    @BindView(R.id.tvPublisher)
    TextView tvPublisher;
    @BindView(R.id.tvBio)
    TextView tvBio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        Hero hero = (Hero) intent.getSerializableExtra("hero");

        Picasso.get().load(hero.getImageurl()).into(ivAvatar);

        tvName.setText(hero.getName());
        tvRealName.setText(hero.getRealname());
        tvTeam.setText(hero.getTeam());
        tvFirstAppeared.setText(hero.getFirstappearance());
        tvCreatedBy.setText(hero.getCreatedby());
        tvPublisher.setText(hero.getPublisher());
        tvBio.setText(hero.getBio());
    }
}
