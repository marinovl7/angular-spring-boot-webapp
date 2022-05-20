import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Message } from './message';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class MessageService {
  //our base url to connect with the back-end
  private apiServerUrl = environment.apiBaseUrl;
  

  constructor(private http: HttpClient) {}


 //function that sends GET REQUEST to the back-end and extracts the data from the database
  public getMessages(): Observable<Message[]> {
    return this.http.get<Message[]>(`${this.apiServerUrl}/all`);
  }
//function that sends POST REQUEST to the back-end and updates the data from the database
  public addMessage(message: Message): Observable<Message> {
    return this.http.post<Message>(`${this.apiServerUrl}/add`, message);
  }
//function that sends DELETE REQUEST to the back-end and deletes a single message from the database
  public deleteMessage(messageId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/delete/${messageId}`);
  }
}
