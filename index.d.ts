declare module 'react-native-topmind';

export interface RNTopmind {
  /**
   * Use it to send event to TopMind.
   * @param name event's name: "menu click" f.e
   * @param eventData Map with data {myParam: "myValue"} f.e
   */
  logEvent(name: string, eventData: {[key: string]: string} ): void;

  /**
   * Use it to persist user identifier
   * It will be passed through all events as userId value
   * @param userId your user id
   */
  setUserId(userId: string): void;

  /**
   * It removes all persisted TopMind data (userId f.e)
   */
  logout(): void;

  /**
   * Sends event that app has started
   */
  applicationStarted(): void;
}
