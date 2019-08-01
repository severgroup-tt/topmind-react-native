declare module 'react-native-topmind-sdk';

export class RNTopmind {

  static initialize(): void;

  /**
   * Use it to send event to TopMind.
   * @param name event's name: "menu click" e.g
   * @param eventData Map with data {foo: "bar"} e.g
   * or {
   *      foo: {
   *        bar: "someString"
   *      }
   *    }
   */
  static logEvent(name: string, eventData: {[key: string]: string | object} ): void;

  /**
   * Use it to persist user identifier
   * It will be passed through all events as userId value
   * @param userId your user id
   */
  static setUserId(userId: string): void;

  /**
   * It removes all persisted TopMind data (userId e.g)
   */
  static logout(): void;

  /**
   * Sends event that app has started
   */
  static applicationStarted(): void;
}
