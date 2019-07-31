require 'json'
package = JSON.parse(File.read('package.json'))

Pod::Spec.new do |s|
  s.name         = 'RNTopmind'
  s.version      = package["version"]
  s.summary      = package["description"]
  s.homepage     = 'https://github.com/severgroup-tt/topmind-react-native'
  s.description  = <<-DESC
                  React Native SDK for Topmind
                   DESC
  s.license      = package["license"]
  s.author       = { 'Kirill Gudkov' => 'for.example.nickname@gmail.com' }
  s.ios.deployment_target = '9.0'
  s.source       = { :git => 'https://github.com/severgroup-tt/topmind-react-native.git' }
  s.source_files = './ios/RNTopmind/**/*.{h,m}'

  s.dependency 'TopMindSDK'
  s.dependency 'React'
end
