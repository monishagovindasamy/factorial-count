import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FactorialCount } from '../component/model/FactorialCount';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  private baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  upload(file: File): Observable<FactorialCount> {
    const formData: FormData = new FormData();
    formData.append('file', file);
    return this.http.post<FactorialCount>(`${this.baseUrl}/upload`, formData, {
      reportProgress: true,
      responseType: 'json',
    });
  }
}
