package com.zhi.remoteservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

import com.zhi.aidl.QueryStudentAIDL;

/**
 * Created by Administrator on 2016/11/3.
 */
public class QueryStudentService extends Service{
    private Binder binder = new StudentQueryBinder();
    private static final String[] names = {
            "张晓晓","沉鱼燕","毕羞花","冬藏青","夏冬春"
    };

    public String query(int no){
        if(no>0 && no<6){
            return names[no-1];
        }
        return "";
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public class StudentQueryBinder extends QueryStudentAIDL.Stub {
        @Override
        public String queryStudent(int number) throws RemoteException {
            return query(number);
        }
    }
}