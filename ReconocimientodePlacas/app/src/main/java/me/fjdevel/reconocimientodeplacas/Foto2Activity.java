package me.fjdevel.reconocimientodeplacas;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import me.fjdevel.reconocimientodeplacas.controllers.GlazedAPI;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Foto2Activity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    Button btnFoto;
    ImageView imagenV;
    Button btnEnviar;
    Bitmap img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto2);

        btnFoto = findViewById(R.id.show_options_button);
        imagenV = findViewById(R.id.set_picture);
        btnEnviar = findViewById(R.id.buttonenviar);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.14:8000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final GlazedAPI glazedAPI = retrofit.create(GlazedAPI.class);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                File filesDir = view.getContext().getFilesDir();
                File f = new File(filesDir,"img"+".jpg");
                OutputStream os;
                try {
                    os = new FileOutputStream(f);
                    img.compress(Bitmap.CompressFormat.JPEG, 100, os);
                    os.flush();
                    os.close();
                } catch (Exception e) {
                    Log.e(getClass().getSimpleName(), "Error writing bitmap", e);
                }
                RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"),f);
                // MultipartBody.Part is used to send also the actual file name
                MultipartBody.Part body =
                        MultipartBody.Part.createFormData("datafile", f.getName(), requestFile);


                Call call = glazedAPI.subirimagen(body);
                call.enqueue(new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) {
                        Toast.makeText(view.getContext(),call.request().url().toString(),Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call call, Throwable t) {
                        Toast.makeText(view.getContext(),t.toString(),Toast.LENGTH_LONG).show();

                    }
                });
            }
        });

        btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                llamarIntent();

            }
        });

    }


    private void llamarIntent(){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            img = (Bitmap) extras.get("data");
            imagenV.setImageBitmap(img);


        }
    }
}
