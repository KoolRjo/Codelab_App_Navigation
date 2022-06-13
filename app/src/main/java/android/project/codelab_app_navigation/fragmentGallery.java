package android.project.codelab_app_navigation;

import android.os.Bundle;
import android.project.codelab_app_navigation.databinding.FragmentGalleryBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragmentGallery extends Fragment {
    private FragmentGalleryBinding binding;
    protected TextView tvGallery;
    private void getAllViews(){
        tvGallery = binding.textGallery;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        binding = FragmentGalleryBinding.inflate(inflater,container,false);
        view = binding.getRoot();
        getAllViews();
        tvGallery.setText(getString(R.string.text_gallery));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
