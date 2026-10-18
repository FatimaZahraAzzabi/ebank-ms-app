import { Component, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AsyncPipe } from '@angular/common';
import { AccountListState, RequestStatus } from '../model/account.model';
import { Observable, map, catchError, of } from 'rxjs';
import {Loading} from '../services/loading';

@Component({
  selector: 'app-accounts',
  imports: [AsyncPipe],
  templateUrl: './accounts.html',
  styleUrl: './accounts.css',
})
export class Accounts {
  private http = inject(HttpClient);
  protected loadService=inject(Loading);

  RequestStatus = RequestStatus;

  accounts$: Observable<AccountListState> = this.http
    .get<any[]>('http://localhost:9999/EBANK-SERVICE/accounts')
    .pipe(
      map(resp => ({
        accounts: resp,
        status: RequestStatus.SUCCESS
      })),
      catchError(err => {
        console.error(err);

        return of({
          accounts: [],
          status: RequestStatus.ERROR,
          errorMessage: 'Erreur lors du chargement des comptes'
        });
      })
    );
}
