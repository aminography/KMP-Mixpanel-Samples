import SwiftUI
import umbrellaKlib

class AppDelegate: NSObject, UIApplicationDelegate {
    
    func application(
            _ application: UIApplication,
            didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil
        ) -> Bool {
            KoinHelperKt.start()
            MixpanelModule.shared.load()
            
            return true
    }
}
