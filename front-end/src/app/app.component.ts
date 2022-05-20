import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Message } from './message';
import { MessageService } from './message.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  //to store all messages in the component class
  public messages: Message[] = [];

  constructor(private messageService: MessageService) {}
  //onInit function to be started directly when we start the app
  ngOnInit(): void {
    this.getMessages();
  }
  //function which calls a function in the message.service to send a GET Request to extract all the existing messages from our database 
  public getMessages(): void {
    this.messageService.getMessages().subscribe(
      (response: Message[]) => {
        this.messages = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  //function to close the modal window for the add new Message form 
  public closeModal(): void {
    const modal = document.getElementById('modal');
    modal?.classList.add('hidden');
  }
  //function to open the modal window for the add new Message form 
  public openModal(): void {
    const modal = document.getElementById('modal');
    modal?.classList.remove('hidden');
  }
  //function which handles our form submission and sends the form inputs to the message.service to send POST Request to the back-end
  //and at the end updates with the existing messages in the database
  
  public addMessage(messageForm: NgForm): void {
    document.getElementById('btn--close-modal')?.click();
    this.messageService.addMessage(messageForm.value).subscribe(
      (response: Message) => {
        this.getMessages();
        messageForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert('Something went wrrong,try again');
      }
    );
  }
//function which handles the deletion of a message and calls a function in  message.service to send DELETE Request to the back-end and at the end updates with the
//existing messages in the database
  public deleteMessage(message: Message): void {
    this.messageService.deleteMessage(message.id).subscribe(
      (response: void) => {
        console.log(response);
        this.getMessages();
      },
      (error: HttpErrorResponse) => {
        alert('Something went wrrong,try again');
      }
    );
  }
}
