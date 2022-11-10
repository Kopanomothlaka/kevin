package com.example.kevindebarber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button serviceFragment, bookingFlagment, GalleryFragment;

    ImageView logo, facebook ,Twitter,App, tiktok,instagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serviceFragment = (Button) findViewById(R.id.servicesBtn);
        bookingFlagment=(Button) findViewById(R.id.bookBtn);
        GalleryFragment = (Button) findViewById(R.id.galleryBtn) ;
        logo=(ImageView) findViewById(R.id.home);
        facebook=(ImageView)findViewById(R.id.facebook);
        Twitter=(ImageView)findViewById(R.id.twitter);
        App=(ImageView)findViewById(R.id.whatapp) ;
        tiktok=(ImageView)findViewById(R.id.tiktok);
        instagram=(ImageView)findViewById(R.id.instagram);

                            serviceFragment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    replaceFragment(new Service_Fragment());

                                }
                            });


                            bookingFlagment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    replaceFragment(new Booking_Fragment());

                                }
                            });
                            GalleryFragment.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    replaceFragment(new GalleryFragment());

                                }
                            });
                            logo.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    startActivity(new Intent(MainActivity.this, MainActivity.class));
                                }
                            });
                            App.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    String sNumber="+27796299439";
                                    Uri uri=Uri.parse(String.format(
                                            "https://api.whatsapp.com/send?phone=%s",sNumber
                                    ));

                                    Intent intent= new Intent(Intent.ACTION_VIEW);
                                    intent.setData(uri);

                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(intent);

                                }
                            } );


                            facebook.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    String sAppLink = "fb://page/237564710351658";
                                    String sPackage="com.facebook.katana";
                                    String sWebLink="https://web.facebook.com/kopano.motlhlaka";
                                    openLink(sAppLink,sPackage,sWebLink);
                                }
                            });

                            instagram.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    String sAppLink = "https://www.instagram.com/kevin_de_barber09";
                                    String sPackage = "com.instagram.android";
                                    openLink(sAppLink,sPackage,sAppLink);
                                }
                            });
                            Twitter.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    String sAppLink = "titter://user?screen_name=kopano_mothlaka";
                                    String sPackage = "com.twitter.android";
                                    String sWebLink = "https://twitter.com/kopano_mothlaka";
                                    openLink(sAppLink,sPackage,sWebLink);

                                }
                            });
                            tiktok.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    String sAppLink = "tiktok://user?screen_name=kopano_mothlaka";
                                    String sPackage = "com.tiktok.android";
                                    String sWebLink = "https://www.tiktok.com/@kevin_de_barber09";
                                    openLink(sAppLink,sPackage,sWebLink);

                                }
                            });














    }

    private void openLink(String sAppLink, String sPackage, String sWebLink) {

            try {
                Uri uri =Uri.parse(sAppLink);
                Intent intent= new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);
                intent.setPackage(sPackage);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
            catch (ActivityNotFoundException activityNotFoundException){
                Uri uri =Uri.parse(sWebLink);
                Intent intent= new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }


    }



    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }
}