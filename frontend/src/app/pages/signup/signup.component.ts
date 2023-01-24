import { UserService } from './../../services/user.service';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  constructor(private UserService:UserService,private snack:MatSnackBar) {}

    public user= {
      username: '',
      password: '',
      firstName: '',
      lastName: '',
      email: '',
    }

  ngOnInit(): void {}
  formSubmit(){
    console.log(this.user);
    if(this.user.username=='' || this.user.username==null){
      Swal.fire('Hata','Kullanıcı adı boş geçilemez !','error')
      return;
    }

    //Doğrulama

    //addUser: userservice
    this.UserService.addUser(this.user).subscribe(
      (data:any)=>{
        //Başarılı
        console.log(data);
        Swal.fire('Başarılı', data.username+ ' Kayıt başarılı!','success')
      },
      (error)=>{
        //Hata
        console.log(error)
        Swal.fire('Hata','Bu kullanıcı mevcut !','error')
      }
    )

  }


}
