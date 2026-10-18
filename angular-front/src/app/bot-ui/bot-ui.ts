import { Component,inject } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {AsyncPipe} from '@angular/common';
import {MarkdownComponent} from 'ngx-markdown';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-bot-ui',
  imports: [
    AsyncPipe,
    MarkdownComponent,
    FormsModule,
  ],
  templateUrl: './bot-ui.html',
  styleUrl: './bot-ui.css',
})
export class BotUi {
  query : any;

  http=inject(HttpClient);
  response$!:Observable<any>
  askAgent(){
     this.response$=this.http.get("http://localhost:8058/chat?query="+this.query,{responseType:'text'});
  }
}
