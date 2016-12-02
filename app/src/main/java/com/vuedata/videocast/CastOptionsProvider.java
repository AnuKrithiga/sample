package com.vuedata.videocast;

import android.content.Context;

import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.OptionsProvider;
import com.google.android.gms.cast.framework.SessionProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rakes on 22-11-2016.
 */


class CastOptionsProvider implements OptionsProvider {

    public static final String CUSTOM_NAMESPACE = "urn:x-cast:custom_namespace";


    @Override
    public CastOptions getCastOptions(Context appContext) {
        List<String> supportedNamespaces = new ArrayList();
        supportedNamespaces.add(CUSTOM_NAMESPACE);
        CastOptions castOptions = new CastOptions.Builder()
                .setReceiverApplicationId(context.getString(R.string.app_name))
                .setSupportedNamespaces(supportedNamespaces)
                .build();
        return castOptions;
    }
    @Override
    public List<SessionProvider> getAdditionalSessionProviders(Context context) {
        return null;
    }
}