package com.philliphsu.clock2;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.philliphsu.clock2.model.AlarmDatabaseHelper.AlarmCursor;
import com.philliphsu.clock2.model.DatabaseManager;
import com.philliphsu.clock2.util.AlarmUtils;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 */
public class OnBootUpAlarmScheduler extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "com.philliphsu.clock2.action.FOO";
    private static final String ACTION_BAZ = "com.philliphsu.clock2.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "com.philliphsu.clock2.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.philliphsu.clock2.extra.PARAM2";

    public OnBootUpAlarmScheduler() {
        super("OnBootUpAlarmScheduler");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context, String param1, String param2) {
        Intent intent = new Intent(context, OnBootUpAlarmScheduler.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, OnBootUpAlarmScheduler.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            // IntentService already works in a background thread, so we don't need to use a loader.
            AlarmCursor cursor = DatabaseManager.getInstance(this).queryAlarms();
            while (cursor.moveToNext()) {
                Alarm alarm = cursor.getAlarm();
                if (alarm.isEnabled()) {
                    AlarmUtils.scheduleAlarm(this, alarm, false);
                }
            }
            cursor.close();

/*            final String action = intent.getAction();
            if (ACTION_FOO.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionFoo(param1, param2);
            } else if (ACTION_BAZ.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionBaz(param1, param2);
            }
*/
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
