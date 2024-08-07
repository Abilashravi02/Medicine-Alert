/**************************************************************************
 *
 * Copyright (C) 2012-2015 Alex Taradov <alex@taradov.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *************************************************************************/

package com.example.a91962.medicinealert;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AlarmReceiver extends BroadcastReceiver
{
  private final String TAG = "AlarmMe";

  @Override
  public void onReceive(Context context, Intent intent)
  {
    Intent newIntent = new Intent(context, AlarmNotification.class);
    Alarm alarm = new Alarm(context);

    alarm.fromIntent(intent);
    alarm.toIntent(newIntent);
    newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);

    Log.i(TAG, "AlarmReceiver.onReceive('" + alarm.getTitle() + "')");




    context.startActivity(newIntent);
  }
}

