package com.saiyou.xposed.simcard;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;


import android.telephony.TelephonyManager;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class Simcard  implements IXposedHookLoadPackage {
	public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
		// TODO Auto-generated method stub

		XposedBridge.log(lpparam.packageName + " [Simcard]");	
		
		// sim is usefully
		findAndHookMethod(TelephonyManager.class.getName(),lpparam.classLoader,"getSimState",new XC_MethodHook(){

			@Override
			protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
				// TODO Auto-generated method stub
				super.beforeHookedMethod(param);
			}

			@Override
			protected void afterHookedMethod(MethodHookParam param) throws Throwable {
				// TODO Auto-generated method stub
				super.afterHookedMethod(param);
				//TelephonyManager.SIM_STATE_READY 5
				param.setResult(TelephonyManager.SIM_STATE_READY);
			}
		
		});
		
		// get sim id
		findAndHookMethod("android.telephony.TelephonyManager",lpparam.classLoader,"getSubscriberId",new XC_MethodHook(){

			@Override
			protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
				// TODO Auto-generated method stub
				//super.beforeHookedMethod(param);
				param.setResult("11111111111111111111111111");
			}
		
		});
		
	}

}
