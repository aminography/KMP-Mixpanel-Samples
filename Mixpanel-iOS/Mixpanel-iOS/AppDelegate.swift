import SwiftUI
import umbrellaKlib

class AppDelegate: NSObject, UIApplicationDelegate {
    
    func application(
            _ application: UIApplication,
            didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil
        ) -> Bool {
            KoinHelperKt.start()
            MixpanelModule.shared.load()
            
            let mixpanel = MixpanelQualifiersKt.MIXPANEL_DELEGATE.resolve()
            mixpanel.doInit(apiToken: BuildProperties.shared.MIXPANEL_API_TOKEN_TEST)
                
            print("XXXXXXXXXXXXXXXXXXX  Lib Version: " + BuildProperties.shared.VERSION)
            
            return true
    }
}
