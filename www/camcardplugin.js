// Empty constructor
function CamcardPlugin() {}

// The function that passes work along to native shells
// Message is a string, duration may be 'long' or 'short'
CamcardPlugin.prototype.show = function(message, duration, successCallback, errorCallback) {
  var options = {};
  options.message = message;
  options.duration = duration;
  cordova.exec(successCallback, errorCallback, 'CamcardPlugin', 'show', [options]);
}

// Installation constructor that binds CamcardPlugin to window
CamcardPlugin.install = function() {
  if (!window.plugins) {
    window.plugins = {};
  }
  window.plugins.camcardPlugin = new CamcardPlugin();
  return window.plugins.camcardPlugin;
};
cordova.addConstructor(CamcardPlugin.install);

