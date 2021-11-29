<?php

namespace App\Http\Controllers;

use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Str;
use Illuminate\Support\Facades\Hash;

class LoginController extends Controller
{

    public function index()
    {

        $data = User::where('pelanggan')->get();
        return response()->json($data);
    }

    public function register(Request $request)
    {
        $this->validate($request,[
            'password' => 'required | min:8 | regex [a-z] | regex [A-Z] | regex [0-9] | regex [@#$&?*%]',
        ]);

    
        $data = [
            'nama' => 'ya',
            'email' => $request->input('email'),
            'password' => $request->input('password'),
            'level' => $request->input('level'),
            'api_token' => '123456',
            'status' => '1',
            'relasi' => $request->input('relasi'),
        ];

        User::create($data);
        $datauser = [
            'message' => 'succes',
            'status' => 202,
            'pesan' => 'Login Berhasil',
            'data' => $data
        ];

        return response()->json($datauser);
    }


    public function login(Request $request)
    {
        $email = $request->input('email');
        $password = $request->input('password');

        $user = User::where([
            'email' => $email,
            'password' => $password
        ])->first();

        if (isset($user)) {
            if ($user->status === 1) {
                if (($password && $email)) {

                    // $user->update([
                    //     'api_token' => $token
                    // ]);

                    return response()->json([
                        'message' => 'succes',
                        'status' => 202,
                        'pesan' => 'Login Berhasil',
                        'data' => $user
                    ]);
                } else {
                    return response()->json([
                        'message' => 'succes',
                        'status' => 202,
                        'pesan' => 'login gagal',
                        'data' => ''
                    ]);
                }
            } else {
                return response()->json([
                    'message' => 'succes',
                    'status' => 202,
                    'pesan' => 'login gagal',
                    'data' => ''
                ]);
            }
        } else {
            return response()->json([
                'message' => 'succes',
                'status' => 202,
                'pesan' => 'login gagal',
                'data' => ''
            ]);
        }
    }


    public function update(Request $request, $id)
    {
        $user = User::where('id', $id)->update($request->all());

        if ($user) {
            return response()->json([
                'pesan' => "Data Sudah di ubah !"
            ]);
        }
    }

}