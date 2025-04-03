import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LogService {

  private apiUrl = 'http://localhost:8081/api/logs'; // Adjust this URL to your backend API

  constructor(private http: HttpClient) {}

  // Get logs from the backend
  getLogs(): Observable<string> {
    return this.http.get(this.apiUrl, { responseType: 'text' });
  }
}
