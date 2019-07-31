declare module 'react-native-topmind';

export class RNTopmind {
  static initialize(): void;
  /**
   * Use it to send event to TopMind.
   * @param name event's name: "menu click" f.e
   * @param eventData Map with data {myParam: "myValue"} f.e
   */
  static logEvent(name: string, eventData: {[key: string]: string} ): void;

  /**
   * Use it to persist user identifier
   * It will be passed through all events as userId value
   * @param userId your user id
   */
  static setUserId(userId: string): void;

  /**
   * It removes all persisted TopMind data (userId f.e)
   */
  static logout(): void;

  /**
   * Sends event that app has started
   */
  static applicationStarted(): void;
}
