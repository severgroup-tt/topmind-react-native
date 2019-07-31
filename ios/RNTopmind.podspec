
Pod::Spec.new do |s|
  s.name         = "RNTopmind"
  s.version      = "1.0.0"
  s.summary      = "RNTopmind"
  s.description  = <<-DESC
                  RNTopmind
                   DESC
  s.homepage     = ""
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "author@domain.cn" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/author/RNTopmind.git", :tag => "master" }
  s.source_files  = "RNTopmind/**/*.{h,m}"
  s.requires_arc = true


  s.dependency 'TopMindSDK', :git => 'https://github.com/severgroup-tt/topmind-ios-framework', :branch => 'master'
  s.dependency "React"
  #s.dependency "others"

end

