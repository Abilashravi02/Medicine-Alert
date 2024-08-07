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

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class AlarmNotification extends Activity
{
  private final String TAG = "AlarmMe";
  int fg;
  private AudioManager myAudioManager;
  private Ringtone mRingtone;
  private Vibrator mVibrator;
  private final long[] mVibratePattern = { 0, 500, 500 };
  private boolean mVibrate;
  private Uri mAlarmSound;
  private long mPlayTime;
  private Timer mTimer = null;
  private Alarm mAlarm;
  private DateTime mDateTime;
  private TextView mTextView;
  private PlayTimerTask mTimerTask;
  int Count_info=1;
  MediaPlayer mediaPlayer;
  @Override
  protected void onCreate(Bundle bundle)
  {
    super.onCreate(bundle);

    getWindow().addFlags(
      WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON |
      WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
      WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);

    setContentView(R.layout.notification);

    mDateTime = new DateTime(this);
    mTextView = (TextView)findViewById(R.id.alarm_title_text);

    readPreferences();

    mRingtone = RingtoneManager.getRingtone(getApplicationContext(), mAlarmSound);
    if (mVibrate)
      mVibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

    start(getIntent());
  }

  @Override
  protected void onDestroy()
  {
    super.onDestroy();
    Log.i(TAG, "AlarmNotification.onDestroy()");

    stop();
  }

  @Override
  protected void onNewIntent(Intent intent)
  {
    super.onNewIntent(intent);
    Log.i(TAG, "AlarmNotification.onNewIntent()");

    addNotification(mAlarm);

    stop();
    start(intent);
  }

  private void start(Intent intent)
  {



      mAlarm = new Alarm(this);
      mAlarm.fromIntent(intent);

      Log.i(TAG, "AlarmNotification.start('" + mAlarm.getTitle() + "')");

    File imageFile = new  File("/storage/emulated/0/"+mAlarm.getTitle()+".mp3");
    try {
      MediaPlayer mediaPlayer = new MediaPlayer();
      mediaPlayer.setDataSource(imageFile.getAbsolutePath());
      mediaPlayer.prepare();
      mediaPlayer.start();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  private void stop()
  {
    Log.i(TAG, "AlarmNotification.stop()");

    mTimer.cancel();
    mRingtone.stop();
    if (mVibrate)
      mVibrator.cancel();
  }

  public void onDismissClick(View view)
  {

    finish();
  }

  private void readPreferences()
  {
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

    mAlarmSound = Uri.parse(prefs.getString("alarm_sound_pref", "DEFAULT_RINGTONE_URI"));
    mVibrate = prefs.getBoolean("vibrate_pref", true);
    mPlayTime = (long)Integer.parseInt(prefs.getString("alarm_play_time_pref", "30")) * 1000;
  }

  private void addNotification(Alarm alarm)
  {
    NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
    Notification notification;
    PendingIntent activity;
    Intent intent;

    intent = new Intent(this.getApplicationContext(), AlarmMe.class);
    intent.setAction(Intent.ACTION_MAIN);
    intent.addCategory(Intent.CATEGORY_LAUNCHER);

    activity = PendingIntent.getActivity(this, (int)alarm.getId(), intent, PendingIntent.FLAG_UPDATE_CURRENT);

    NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
    notification = builder
        .setContentIntent(activity)
        .setSmallIcon(R.drawable.ic_notification)
        .setAutoCancel(true)
        .setContentTitle("Missed alarm: " + alarm.getTitle())
        .setContentText(mDateTime.formatDetails(alarm))
        .build();

    notificationManager.notify((int)alarm.getId(), notification);


  }

  @Override
  public void onBackPressed()
  {
    finish();
  }

  private class PlayTimerTask extends TimerTask
  {
    @Override
    public void run()
    {
      Log.i(TAG, "AlarmNotification.PalyTimerTask.run()");




      addNotification(mAlarm);
      finish();
    }
  }
}

